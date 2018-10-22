/*********************************************************************************************************************
 *
 * COPYRIGHT 2017 TETRABIT DO BRASIL
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
package br.com.tetrabit.jira.plugins.oc.model.ao;

import br.com.tetrabit.jira.plugins.oc.model.Constants.Enums;
import net.java.ao.Mutator;
import net.java.ao.Preload;
import net.java.ao.schema.NotNull;
import net.java.ao.schema.Table;
import net.java.ao.Entity;

@Table("OCJ_PERMISSION")
@Preload
public interface Permission extends Entity {

  Group getGroup();

  @Mutator("USER_GROUP")
  String getUserGroup();

  @Mutator("USER")
  String getUser();

  @Mutator("SCENARIO")
  @NotNull
  String getScenario();

  @Mutator("STATUS")
  @NotNull
  Boolean getStatus();

  void setGroup(Group group);
  void setUserGroup(String userGroup);
  void setUser(String user);
  void setScenario(Enums scenario);
  void setStatus(Boolean status);
}
