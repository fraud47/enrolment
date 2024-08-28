package zw.apkmechanik.enrolment.domain.models.notifications;

import zw.co.dreamhub.domain.models.common.Media;
import zw.co.dreamhub.domain.models.school.School;

import java.time.ZonedDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Marlvin Chihota
 * Email marlvinchihota@gmail.com
 * Created on 23/3/2024
 */
public class Notification {
  private School school;
  // todo : create this -> teachers/ students / next of kin / grade
  private NotificationType type;

  // todo : create this -> sms / email / firebase / whatsapp
  private Set<Channel> channels = new LinkedHashSet<>();
  private ZonedDateTime broadcastOn;
  private String title;
  private String message;
  private String remarks;
  private Set<Media> media = new LinkedHashSet<>();
 private Set<String> receipiants = new LinkedHashSet<>();

}
