/*********************************************************************************************************************
 *
 * COPYRIGHT 2018 TETRABIT DO BRASIL
 *
 * Terms of Use: This source code is licensed under the
 *
 * Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International (CC BY-NC-ND 4.0) license,
 *
 * where a full copy of these terms follow this work in the LICENSE file and is also available at:
 *
 * https://creativecommons.org/licenses/by-nc-nd/4.0/
 *
 * You may not use this source code except in compliance with this License.
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 ********************************************************************************************************************/
package br.com.tetrabit.jira.plugins.oc.action.i18n;

import com.atlassian.jira.web.action.JiraWebActionSupport;
import com.google.common.base.Strings;


/**
 * Base class for all Web Actions in the plugin.<br>
 * This class act as a template, delegate, facade and utility for many web operations.<br>
 */

public abstract class AbstractAction extends JiraWebActionSupport {

  protected String baseKey = "";

  public AbstractAction() {
    setBaseKey();
  }

  /**
   * Template method to set i18n base key.<br>
   * A general implementation is: "baseKey = BASE_KEY;"
   *
   * @see #setBaseKey()  for a good practice implementation
   */
  protected abstract void setBaseKey();

  /**
   * Shortcut for i18n in conjunction with #setBaseKey() method.
   *
   * @param key
   *     Full (take precedence) or a partial i18n key
   * @return
   */
  public String t(String key) {
    String result = null;
    if (key.startsWith(".")) {
      String fullyKey = baseKey + ".detail." + key;
      result = getUnescapedText(fullyKey);
      if (Strings.isNullOrEmpty(result)) {
        result = "No i18n for: " + fullyKey;
      }
    } else {
      result = getUnescapedText(key);
      if (Strings.isNullOrEmpty(result)) {
        result = "No i18n for: " + key;
      }
    }
    return result;
  }

  /**
   * Retrieve i18 entries for header texts
   *
   * @param key
   *     "title" or "description"
   * @return
   */
  public String h(String key) {
    if (key.equals("title") || key.equals("description")) {
      return t(baseKey + ".header." + key);
    } else {
      return t(key);
    }
  }

  /**
   * Retrieve i18 entries for field texts
   *
   * @param key
   *     The partial field entry, starting with dot (.), like ".name.title" or ".name" or ".name.description".
   *     Note that if key as specified in a short version, like ".name", the value returned is equivalent to the
   *     "title" entry, like ".name.title"
   * @return
   */
  public String f(String key) {
    if (key.startsWith(baseKey + ".detail.field")) {
      if ((key.endsWith("title") || key.endsWith("description"))) {
        return t(key);
      } else {
        return f(key + ".title");
      }
    } else {
      if (key.startsWith(".")) {
        return f(baseKey + ".detail.field" + key);
      } else {
        return f(baseKey + ".detail.field." + key);
      }
    }
  }

  /**
   * Retrieve i18 entries for user/system operations
   *
   * @param key
   *     The fully or a partial operation entry, like:<br>
   *     "operation.edit.title"<br>
   *     "operation.edit.description"<br>
   *     "operation.edit"<br>
   *     ".edit.title"<br>
   *     ".edit.description"<br>
   *     "edit.title"<br>
   *     "edit.description"<br>
   *     ".edit"<br>
   *     "edit" (Preferred way)<br>
   *     NOTE: When the suffix "title/description" was absent, the "title" is returned.
   * @return
   */
  public String o(String key) {
    if (key.startsWith("operation.")) {
      if ((key.endsWith("title") || key.endsWith("description"))) {
        return t(key);
      } else {
        return o(key + ".title");
      }
    } else {
      if (key.startsWith(".")) {
        return o("operation" + key);
      } else {
        return o("operation." + key);
      }
    }
  }
}
