package org.hl7.gravity.refimpl.sdohexchange.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.hl7.fhir.r4.model.Task;
import org.hl7.gravity.refimpl.sdohexchange.annotation.TaskStatusValueMatch;
import org.springframework.util.StringUtils;

// Copied from ehr/app/src/main/java/org/hl7/gravity/refimpl/sdohexchange/dto/request/UpdateTaskRequestDto.java
@Getter
@Setter
@TaskStatusValueMatch.List(
    {@TaskStatusValueMatch(updateStatus = TaskStatus.CANCELLED, requiredFields = {"statusReason"},
        message = "Updating task status to 'Canceled' requires 'statusReason'.")})
public class UpdateOurTaskRequestDto {

  private TaskStatus status;
  private String comment;
  private String statusReason;

  public Task.TaskStatus getTaskStatus() {
    return status == null ? null : status.getTaskStatus();
  }

  public boolean isOnlyAddComment() {
    return (status == null && statusReason == null) && StringUtils.hasText(comment);
  }
}
