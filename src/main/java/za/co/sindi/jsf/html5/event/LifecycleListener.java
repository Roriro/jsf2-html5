/**
 * 
 */
package za.co.sindi.jsf.html5.event;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 * @author Bienfait Sindi
 * @since 22 July 2013
 *
 */
public class LifecycleListener implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5406019081075799484L;

	/* (non-Javadoc)
	 * @see javax.faces.event.PhaseListener#afterPhase(javax.faces.event.PhaseEvent)
	 */
	public void afterPhase(PhaseEvent event) {
		// TODO Auto-generated method stub
		System.out.println("END PHASE " + event.getPhaseId());
	}

	/* (non-Javadoc)
	 * @see javax.faces.event.PhaseListener#beforePhase(javax.faces.event.PhaseEvent)
	 */
	public void beforePhase(PhaseEvent event) {
		// TODO Auto-generated method stub
		System.out.println("START PHASE " + event.getPhaseId());
	}

	/* (non-Javadoc)
	 * @see javax.faces.event.PhaseListener#getPhaseId()
	 */
	public PhaseId getPhaseId() {
		// TODO Auto-generated method stub
		return PhaseId.ANY_PHASE;
	}
}
