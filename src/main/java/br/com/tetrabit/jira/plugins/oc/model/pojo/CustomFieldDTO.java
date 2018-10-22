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
package br.com.tetrabit.jira.plugins.oc.model.pojo;

import java.io.Serializable;

public class CustomFieldDTO implements Serializable {

  private long id;
  private String name;
  private long customFieldID;
  private String type;
  private GroupDTO groupDTO;

  CustomFieldDTO() {
    super();
  }

  public CustomFieldDTO(String name, long customFieldID, String type, GroupDTO groupDTO) {
    this.name = name;
    this.customFieldID = customFieldID;
    this.type = type;
    this.groupDTO = groupDTO;
  }

  public long getId(){
    return this.id;
  }

  public void setId(long id){
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getCustomFieldID() {
    return customFieldID;
  }

  public void setCustomFieldID(long customFieldID) {
    this.customFieldID = customFieldID;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public GroupDTO getGroupDTO() {
    return groupDTO;
  }

  public void setGroupDTO(GroupDTO groupDTO) {
    this.groupDTO = groupDTO;
  }
}
