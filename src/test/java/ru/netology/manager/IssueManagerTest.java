package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class IssueManagerTest {
    private IssueManager manager = new IssueManager();
    Issue first = new Issue(1, "One", "Author1", 11, true, Set.of("Qwerty"), Set.of("Yuio"));
    Issue second = new Issue(2, "Two", "Author2", 12, false, Set.of("Asd"), Set.of("Fgh"));
    Issue third = new Issue(3, "Three", "Author3", 13, true, Set.of("Zxc"), Set.of("Vbn"));

    @BeforeEach
    void setUp() {
        manager.addIssue(first);
        manager.addIssue(second);
        manager.addIssue(third);
    }

    @Test
    void shouldShowOpenedIssues() {
        Collection<Issue> actual = manager.openIssues();
        Collection<Issue> expected = List.of(first, third);
        assertEquals(expected, actual);
    }

    @Test
    void shouldShowClosedIssue() {
        Collection<Issue> actual = manager.closedIssue();
        Collection<Issue> expected = List.of(second);
        assertEquals(expected, actual);
    }

    @Test
    void findBy() {
    }

    @Test
    void shouldShowAssigneeIssues() {
        Collection<Issue> actual = manager.filterByAssignee("Fgh");
        Collection<Issue> expected = List.of(second);
        assertEquals(expected, actual);
    }

    @Test
    void shouldShowLabelIssues() {
        Collection<Issue> actual = manager.filterByLabel("Zxc");
        Collection<Issue> expected = List.of(third);
        assertEquals(expected, actual);
    }

    @Test
    void shouldShowByAuthor() {
        Collection<Issue> actual = manager.filterByAuthor("Author1");
        Collection<Issue> expected = List.of(first);
        assertEquals(expected, actual);
    }

    @Test
    void shouldShowOpenIssues() {
        manager.toOpenIssue(1);
        Collection<Issue> actual = manager.openIssues();
        Collection<Issue> expected = List.of(first, third);
        assertEquals(expected, actual);
    }

    @Test
    void shouldShowCloseIssue() {
        manager.toCloseIssue(2);
        Collection<Issue> actual = manager.closedIssue();
        Collection<Issue> expected = List.of(second);
        assertEquals(expected, actual);
    }
}