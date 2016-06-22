/**
 * 
 */
package za.co.sindi.jsf.html5.utils;

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItem;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 * This class is a copy of
 * <code>javax.faces.component.SelectItemsIterator</code> class as the mentioned
 * class is package private.
 * 
 * @author Bienfait Sindi
 * @since 28 August 2013
 * 
 */
public class SelectItemsIterator implements Iterator<SelectItem> {

	private FacesContext context;
	private Iterator<UIComponent> children;
	private Iterator<SelectItem> items;
	
	/**
     * Expose single SelectItems via an Iterator.  This iterator will be
     * reset/reused for each individual SelectItem instance encountered.
     */
    private SingleElementIterator singleItemIterator;

	/**
	 * 
	 * @param context
	 * @param component
	 */
	public SelectItemsIterator(FacesContext context, UIComponent component) {
		super();
		// TODO Auto-generated constructor stub
		if (component == null) {
			throw new IllegalArgumentException("UIComponent is null.");
		}

		if (component.getChildCount() > 0) {
			children = component.getChildren().iterator();
		}

		this.context = context;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#hasNext()
	 */
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if (items != null) {
			if (items.hasNext()) {
				return (true);
			} else {
				items = null;
			}
		}
		Object next = findNextValidChild();
		while (next != null) {
			initializeItems(next);
			if (items != null) {
				return true;
			} else {
				next = findNextValidChild();
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#next()
	 */
	public SelectItem next() {
		// TODO Auto-generated method stub
		if (!hasNext()) {
			throw new NoSuchElementException();
		}

		if (items != null) {
			return (items.next());
		}

		return next();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#remove()
	 */
	public void remove() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Method not supported.");
	}

	/**
	 * <p>
	 * Initializes the <code>items</code> instance variable with an
	 * <code>Iterator</code> appropriate to the UISelectItem(s) value.
	 * </p>
	 */
	@SuppressWarnings("rawtypes")
	private void initializeItems(Object kid) {

		if (kid instanceof UISelectItem) {
			UISelectItem ui = (UISelectItem) kid;
			SelectItem item = (SelectItem) ui.getValue();
			if (item == null) {
				item = new SelectItem(ui.getItemValue(), ui.getItemLabel(),
						ui.getItemDescription(), ui.isItemDisabled(),
						ui.isItemEscaped(), ui.isNoSelectionOption());
			}
			updateSingeItemIterator(item);
			items = singleItemIterator;
		} else if (kid instanceof UISelectItems) {
			UISelectItems ui = (UISelectItems) kid;
			Object value = ui.getValue();
			if (value != null) {
				if (value instanceof SelectItem) {
					updateSingeItemIterator((SelectItem) value);
					items = singleItemIterator;
				} else if (value.getClass().isArray()) {
					items = new ArrayIterator(context, (UISelectItems) kid, value);
				} else if (value instanceof Iterable) {
					items = new IterableItemIterator(context, (UISelectItems) kid,
							(Iterable<?>) value);
				} else if (value instanceof Map) {
					items = new MapIterator((Map) value);
				} else {
					throw new IllegalArgumentException();
				}
			}
			if (items != null && !items.hasNext()) {
				items = null;
			}
		}

	}

	/**
	 * @return the next valid child for processing
	 */
	private Object findNextValidChild() {

		if (children.hasNext()) {
			Object next = children.next();
			while (children.hasNext()
					&& !(next instanceof UISelectItem || next instanceof UISelectItems)) {
				next = children.next();
			}
			if (next instanceof UISelectItem || next instanceof UISelectItems) {
				return next;
			}
		}
		return null;

	}

	/**
	 * Update the <code>singleItemIterator</code> with the provided
	 * <code>item</code>
	 * 
	 * @param item
	 *            the {@link SelectItem} to expose as an Iterator
	 */
	private void updateSingeItemIterator(SelectItem item) {

		if (singleItemIterator == null) {
			singleItemIterator = new SingleElementIterator();
		}
		singleItemIterator.updateItem(item);

	}

	// ---------------------------------------------------------- Nested Classes

	/**
	 * Exposes single {@link SelectItem} instances as an Iterator.
	 */
	private static final class SingleElementIterator implements
			Iterator<SelectItem> {

		private SelectItem item;
		private boolean nextCalled;

		// ----------------------------------------------- Methods from Iterator

		public boolean hasNext() {

			return !nextCalled;

		}

		public SelectItem next() {

			if (nextCalled) {
				throw new NoSuchElementException();
			}
			nextCalled = true;
			return item;

		}

		public void remove() {

			throw new UnsupportedOperationException();

		}

		// ----------------------------------------------------- Private Methods

		private void updateItem(SelectItem item) {

			this.item = item;
			nextCalled = false;

		}

	} // END SingleElementIterator

	/**
	 * Iterates over a <code>Map</code> of values exposing each entry as a
	 * SelectItem. Note that this will do so re-using the same SelectItem but
	 * changing the value and label as appropriate.
	 */
	private static final class MapIterator implements Iterator<SelectItem> {

		private SelectItem item = new SelectItem();
		@SuppressWarnings("rawtypes")
		private Iterator iterator;

		// -------------------------------------------------------- Constructors

		private MapIterator(@SuppressWarnings("rawtypes") Map map) {

			this.iterator = map.entrySet().iterator();

		}

		// ----------------------------------------------- Methods from Iterator

		public boolean hasNext() {

			return iterator.hasNext();

		}

		public SelectItem next() {

			@SuppressWarnings("rawtypes")
			Map.Entry entry = (Map.Entry) iterator.next();
			Object key = entry.getKey();
			Object value = entry.getValue();
			item.setLabel(((key != null) ? key.toString() : value.toString()));
			item.setValue(((value != null) ? value : ""));
			return item;

		}

		public void remove() {

			throw new UnsupportedOperationException();

		}

	} // END MapIterator

	/**
	 * <p>
	 * Base class to support iterating over Collections or Arrays that may or
	 * may not contain <code>SelectItem</code> instances.
	 * </p>
	 */
	private static abstract class GenericObjectSelectItemIterator implements
			Iterator<SelectItem> {

		/**
		 * SelectItem that is updated based on the current Object being iterated
		 * over.
		 */
		private GenericObjectSelectItem genericObjectSI;

		/**
		 * The source <code>UISelectItems</code>.
		 */
		protected UISelectItems sourceComponent;

		// -------------------------------------------------------- Constructors

		protected GenericObjectSelectItemIterator(UISelectItems sourceComponent) {

			this.sourceComponent = sourceComponent;

		}

		// --------------------------------------------------- Protected Methods

		protected SelectItem getSelectItemFor(FacesContext context, Object value) {

			if (genericObjectSI == null) {
				genericObjectSI = new GenericObjectSelectItem(sourceComponent);
			}

			genericObjectSI.updateItem(context, value);
			return genericObjectSI;

		}

		// ------------------------------------------------------ Nested Classes

		/**
		 * A <code>SelectItem</code> implementation to support generating unique
		 * <code>SelectItem</code> values based on <code>ValueExpressions</code>
		 * from the owning {@link UISelectItems} instance.
		 */
		private static final class GenericObjectSelectItem extends SelectItem {

			private static final String VAR = "var";
			private static final String ITEM_VALUE = "itemValue";
			private static final String ITEM_LABEL = "itemLabel";
			private static final String ITEM_DESCRIPTION = "itemDescription";
			private static final String ITEM_ESCAPED = "itemLabelEscaped";
			private static final String ITEM_DISABLED = "itemDisabled";
			private static final String NO_SELECTION_OPTION = "noSelectionOption";

//			/**
//			 * Resolves to the value of the <code>SelectItem</code>.
//			 */
//			private ValueExpression itemValue;
//
//			/**
//			 * Resolves to the label of the <code>SelectItem</code>.
//			 */
//			private ValueExpression itemLabel;
//
//			/**
//			 * Resolves to the description of the <code>SelectItem</code>.
//			 */
//			private ValueExpression itemDescription;
//
//			/**
//			 * Determines the value for the escaped property of the
//			 * <code>SelectItem</code>.
//			 */
//			private ValueExpression itemEscaped;
//
//			/**
//			 * Determines the value for the disabled property of the
//			 * <code>SelectItem</code>/
//			 */
//			private ValueExpression itemDisabled;
//
//			/**
//			 * Determines the value for the noSelectionOption property of the
//			 * <code>SelectItem</code>/
//			 */
//			private ValueExpression noSelectionOption;

			/**
			 * The request-scoped variable under which the current object will
			 * be exposed.
			 */
			private String var;

			private UISelectItems sourceComponent;

			// --------------------------------------------------------
			// Constructors

			private GenericObjectSelectItem(UISelectItems sourceComponent) {

				var = (String) sourceComponent.getAttributes().get(VAR);
				this.sourceComponent = sourceComponent;
				// itemValue = sourceComponent.getValueExpression(ITEM_VALUE);
				// itemLabel = sourceComponent.getValueExpression(ITEM_LABEL);
				// itemDescription =
				// sourceComponent.getValueExpression(ITEM_DESCRIPTION);
				// itemEscaped =
				// sourceComponent.getValueExpression(ITEM_ESCAPED);
				// itemDisabled =
				// sourceComponent.getValueExpression(ITEM_DISABLED);
				// noSelectionOption =
				// sourceComponent.getValueExpression(NO_SELECTION_OPTION);

			}

			// ----------------------------------------------------- Private
			// Methods

			/**
			 * Updates the <code>SelectItem</code> properties based on the
			 * current value.
			 * 
			 * @param context
			 *            the {@link FacesContext} for the current request
			 * @param value
			 *            the value to build the updated values from
			 */
			private void updateItem(FacesContext context, Object value) {

				Map<String, Object> reqMap = context.getExternalContext()
						.getRequestMap();
				Object oldVarValue = null;
				if (var != null) {
					oldVarValue = reqMap.put(var, value);
				}
				try {
					Map<String, Object> attrs = sourceComponent.getAttributes();
					Object itemValueResult = attrs.get(ITEM_VALUE);
					Object itemLabelResult = attrs.get(ITEM_LABEL);
					Object itemDescriptionResult = attrs.get(ITEM_DESCRIPTION);
					Object itemEscapedResult = attrs.get(ITEM_ESCAPED);
					Object itemDisabledResult = attrs.get(ITEM_DISABLED);
					Object noSelectionOptionResult = attrs
							.get(NO_SELECTION_OPTION);
					setValue(((itemValueResult != null) ? itemValueResult
							: value));
					setLabel(((itemLabelResult != null) ? itemLabelResult
							.toString() : value.toString()));
					setDescription(((itemDescriptionResult != null) ? itemDescriptionResult
							.toString() : null));
					setEscape(((itemEscapedResult != null) ? Boolean
							.valueOf(itemEscapedResult.toString()) : false));
					setDisabled(((itemDisabledResult != null) ? Boolean
							.valueOf(itemDisabledResult.toString()) : false));
					setNoSelectionOption(((noSelectionOptionResult != null) ? Boolean
							.valueOf(noSelectionOptionResult.toString())
							: false));
				} finally {
					if (var != null) {
						if (oldVarValue != null) {
							reqMap.put(var, oldVarValue);
						} else {
							reqMap.remove(var);
						}
					}
				}

			}

			// --------------------------------------- Methods from Serializable

			private void writeObject(ObjectOutputStream out) throws IOException {

				throw new NotSerializableException();

			}

			private void readObject(ObjectInputStream in) throws IOException {

				throw new NotSerializableException();

			}

		} // END GenericObjectSelectItem

	} // END GenericObjectSelectItemIterator

	/**
	 * Handles arrays of <code>SelectItem</code>s, generic Objects, or
	 * combintations of both.
	 * 
	 * A single <code>GenericObjectSelectItem</code> will be leverage for any
	 * non-<code>SelectItem</code> objects encountered.
	 */
	private static final class ArrayIterator extends
			GenericObjectSelectItemIterator {

		private FacesContext context;
		private Object array;
		private int count;
		private int index;

		// -------------------------------------------------------- Constructors

		private ArrayIterator(FacesContext context, UISelectItems sourceComponent,
				Object array) {

			super(sourceComponent);
			this.context = context;
			this.array = array;
			count = Array.getLength(array);

		}

		// ----------------------------------------------- Methods from Iterator

		public boolean hasNext() {

			return (index < count);

		}

		public SelectItem next() {

			if (index >= count) {
				throw new NoSuchElementException();
			}

			Object item = Array.get(array, index++);
			if (item instanceof SelectItem) {
				return (SelectItem) item;
			} else {
				return getSelectItemFor(context, item);
			}

		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

	} // END ArrayIterator

	/**
	 * Handles Collections of <code>SelectItem</code>s, generic Objects, or
	 * combintations of both.
	 * 
	 * A single <code>GenericObjectSelectItem</code> will be leverage for any
	 * non-<code>SelectItem</code> objects encountered.
	 */
	private static final class IterableItemIterator extends
			GenericObjectSelectItemIterator {

		private FacesContext context;
		private Iterator<?> iterator;

		// -------------------------------------------------------- Constructors

		private IterableItemIterator(FacesContext context,
				UISelectItems sourceComponent, Iterable<?> iterable) {

			super(sourceComponent);
			this.context = context;
			this.iterator = iterable.iterator();

		}

		// ----------------------------------------------- Methods from Iterator

		public boolean hasNext() {

			return iterator.hasNext();

		}

		public SelectItem next() {

			Object item = iterator.next();
			if (item instanceof SelectItem) {
				return (SelectItem) item;
			} else {
				return getSelectItemFor(context, item);
			}

		}

		public void remove() {

			throw new UnsupportedOperationException();

		}

	} // END CollectionItemIterator

}
