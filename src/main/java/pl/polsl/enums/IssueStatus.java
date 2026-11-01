
package pl.polsl.enums;


/**
 * Defines the lifecycle statuses available for an issue.
 *
 * @author Oleksandr Holobokov
 * @version 1.1
 */
public enum IssueStatus {
    /** Issue is waiting to be started. */
    TO_DO,
    /** Issue is currently being implemented. */
    IN_PROGRESS,
    /** Issue is awaiting review. */
    IN_REVIEW,
    /** Issue has been completed. */
    DONE
}
