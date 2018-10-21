package br.com.tetrabit.jira.plugins.oc.action;

import br.com.tetrabit.jira.plugins.oc.action.i18n.AbstractAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OptionCreatorAction extends AbstractAction {
  private static final Logger log = LoggerFactory.getLogger(OptionCreatorAction.class);

  /**
   * Base key for i18n
   */
  private static final String BASE_KEY = "option-creator";

  @Override
  protected void setBaseKey() {
    baseKey = BASE_KEY;
  }

  protected String doExecute(){
    return SUCCESS;
  }

}
