/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.activiti.explorer;

import java.text.MessageFormat;

import org.activiti.explorer.ui.MainWindow;

import com.vaadin.ui.Window.Notification;


/**
 * @author Joram Barrez
 */
public class NotificationManager {
  
  protected MainWindow mainWindow;
  protected I18nManager i18nManager;
  
  public NotificationManager(MainWindow mainWindow, I18nManager i18nManager) {
    this.mainWindow = mainWindow;
    this.i18nManager = i18nManager;
  }
  
  public void showErrorNotification(String captionKey, String description) {
    mainWindow.showNotification(i18nManager.getMessage(captionKey), "<br/>" + description, Notification.TYPE_ERROR_MESSAGE);
  }
  
  public void showErrorNotification(String captionKey, Exception exception) {
    mainWindow.showNotification(i18nManager.getMessage(captionKey), "<br/>" + exception.getMessage(), Notification.TYPE_ERROR_MESSAGE);
  }
  
  public void showInformationNotification(String key) {
    mainWindow.showNotification(i18nManager.getMessage(key), Notification.TYPE_HUMANIZED_MESSAGE);
  }
  
  public void showInformationNotification(String key, Object ... params) {
    mainWindow.showNotification(MessageFormat.format(i18nManager.getMessage(key), params),
            Notification.TYPE_HUMANIZED_MESSAGE);
  }
  
}
