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

import net.java.ao.Entity;
import net.java.ao.Mutator;
import net.java.ao.OneToMany;
import net.java.ao.Preload;
import net.java.ao.schema.NotNull;
import net.java.ao.schema.Table;

@Table("OCJ_GROUP")
@Preload
public interface Group extends Entity {

  @Mutator("NAME")
  @NotNull
  String getName();

  @OneToMany
  CustomField[] getCustomField();

  @OneToMany
  Permission[] getPermission();

  @Mutator("STATUS")
  @NotNull
  Boolean getStatus();

  void setName();
  void setStatus(Boolean status);

}
