package test.certif.bean;

import java.util.Map;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Antonio Goncalves
 */
public abstract class AbstractAction {
	
		protected String identifier;

        // ======================================
        // = Attributs =
        // ======================================
        protected Logger logger = Logger.getLogger(AbstractAction.class.getName());
        private final String cname = this.getClass().getName();

        // ======================================
        // = Constantes =
        // ======================================

        // ======================================
        // = Constructeurs =
        // ======================================

        // ======================================
        // = Methodes publiques =
        // ======================================

        // ======================================
        // = Methodes Protégées =
        // ======================================

        protected void addMessage(String sourceClass, String sourceMethod,
                        Throwable throwable) {

                addErrorMessage(throwable.getMessage());
                logger.throwing(sourceClass, sourceMethod, throwable);

        }

        protected void addWarningMessage(String message) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                                message, null));
        }

        protected void addErrorMessage(String message) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                message, null));
        }

        protected String getParam(String param) {
                final String mname = "getParam";
                logger.entering(cname, mname);

                FacesContext context = FacesContext.getCurrentInstance();
                Map<String, String> map = context.getExternalContext()
                                .getRequestParameterMap();
                String result = map.get(param);

                logger.exiting(cname, mname, result);
                return result;
        }

        protected Long getParamId(String param) {
                final String mname = "getParamId";
                logger.entering(cname, mname);

                Long result = Long.valueOf(getParam(param));

                logger.exiting(cname, mname, result);
                return result;
        }
        
        public String logout(){
        	FacesContext context = FacesContext.getCurrentInstance();
        	ExternalContext ec = context.getExternalContext();
        	final HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        	request.getSession(false).invalidate(); // on invalide
        	return "logout";
        }

		public String getIdentifier() {
        	FacesContext context = FacesContext.getCurrentInstance();
        	ExternalContext ec = context.getExternalContext();
        	final HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        	if ((request.getUserPrincipal()!= null) && (request.getUserPrincipal().getName() != null)){
        		return request.getUserPrincipal().getName();
        	}else{
        		return "none";
        	}
		}

		public void setIdentifier(String identifier) {
			this.identifier = identifier;
		}
        
        
 }
