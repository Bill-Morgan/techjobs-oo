package org.launchcode.models.forms;

import org.launchcode.models.*;
import org.launchcode.models.data.JobData;
import org.launchcode.models.data.JobFieldData;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

/**
 * Created by LaunchCode
 */
public class JobForm {

    @NotNull
    @Size(min=1, message = "Name may not be empty")
    private String name;

    @NotNull
    private int employerId;

    /*
        TODO #3 - Included other fields needed to create a job,
        with correct validation attributes and display names.
        Don't forget to add getters and setters
     */
    @NotNull
    private int locationsId;
    @NotNull
    private int coreCompetenciesId;
    @NotNull
    private int positionTypesId;


    private ArrayList<Employer> employers;
    private ArrayList<Location> locations;
    private ArrayList<CoreCompetency> coreCompetencies;
    private ArrayList<PositionType> positionTypes;

    private JobFieldData jobFieldData = new JobFieldData();

    public JobForm() {

        JobData jobData = JobData.getInstance();

        employers = jobData.getEmployers().findAll();

        /*
            TODO #4 - populate the other ArrayList collections needed in the view
        */

        locations = jobData.getLocations().findAll();
        coreCompetencies = jobData.getCoreCompetencies().findAll();
        positionTypes = jobData.getPositionTypes().findAll();

        for (JobField eachEmp : employers) {
            jobFieldData.add(eachEmp);
        }
        for (JobField eachLoc : locations) {
            jobFieldData.add(eachLoc);
        }
        for (JobField eachPosType : positionTypes) {
            jobFieldData.add(eachPosType);
        }
        for (JobField eachCoreComp : coreCompetencies) {
            jobFieldData.add(eachCoreComp);
        }

    }

    public JobFieldData getJobFieldData() {
        return jobFieldData;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployerId() {
        return employerId;
    }

    public void setEmployerId(int employerId) {
        this.employerId = employerId;
    }

    public ArrayList<Employer> getEmployers() {
        return employers;
    }

    public void setEmployers(ArrayList<Employer> employers) {
        this.employers = employers;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    public ArrayList<CoreCompetency> getCoreCompetencies() {
        return coreCompetencies;
    }

    public void setCoreCompetencies(ArrayList<CoreCompetency> coreCompetencies) {
        this.coreCompetencies = coreCompetencies;
    }

    public ArrayList<PositionType> getPositionTypes() {
        return positionTypes;
    }

    public void setPositionTypes(ArrayList<PositionType> positionTypes) {
        this.positionTypes = positionTypes;
    }

    public int getLocationsId() {
        return locationsId;
    }

    public void setLocationsId(int locationsId) {
        this.locationsId = locationsId;
    }

    public int getCoreCompetenciesId() {
        return coreCompetenciesId;
    }

    public void setCoreCompetenciesId(int coreCompetenciesId) {
        this.coreCompetenciesId = coreCompetenciesId;
    }

    public int getPositionTypesId() {
        return positionTypesId;
    }

    public void setPositionTypesId(int positionTypesId) {
        this.positionTypesId = positionTypesId;
    }
}
