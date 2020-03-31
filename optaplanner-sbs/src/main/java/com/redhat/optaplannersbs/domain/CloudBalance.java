package com.redhat.optaplannersbs.domain;

import java.util.List;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

/**
 * CloudBalancingSolution
 */
@PlanningSolution
public class CloudBalance {

    @PlanningEntityCollectionProperty
    private List<Process> processes;

    @ProblemFactCollectionProperty
    @ValueRangeProvider(id = "computer")
    private List<Computer> computers;

    @PlanningScore
    private HardSoftScore score;

    public CloudBalance() {
    }

    public CloudBalance(List<Process> processes, List<Computer> computers) {
        this.processes = processes;
        this.computers = computers;
    }

    public List<Process> getProcesses() {
        return processes;
    }

    public void setProcesses(List<Process> processes) {
        this.processes = processes;
    }

    public List<Computer> getComputers() {
        return computers;
    }

    public void setComputers(List<Computer> computers) {
        this.computers = computers;
    }

    public HardSoftScore getScore() {
        return score;
    }

    public void setScore(HardSoftScore score) {
        this.score = score;
    }

}