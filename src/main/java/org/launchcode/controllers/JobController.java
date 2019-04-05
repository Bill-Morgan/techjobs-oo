package org.launchcode.controllers;

import org.launchcode.models.*;
import org.launchcode.models.data.JobDataImporter;
import org.launchcode.models.data.JobFieldData;
import org.launchcode.models.forms.JobForm;
import org.launchcode.models.data.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.rmi.runtime.NewThreadAction;

import javax.validation.Valid;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping(value = "job")
public class JobController {

    private JobData jobData = JobData.getInstance();

    // The detail display for a given Job at URLs like /job?id=17
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, int id) {

        // TODO #1 - get the Job with the given ID and pass it into the view
        Job job = jobData.findById(id);
        model.addAttribute("job", job);
        return "job-detail";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "Add Job");
        model.addAttribute(new JobForm());
        return "new-job";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid JobForm jobForm, Errors errors) {

        // TODO #6 - Validate the JobForm model, and if valid, create a
        // new Job and add it to the jobData data store. Then
        // redirect to the job detail view for the new Job.

     //   return "";
        if (!errors.hasErrors()) {
            Employer employer = (Employer) jobForm.getJobFieldData().findById(jobForm.getEmployerId());
            Location location = (Location) jobForm.getJobFieldData().findById(jobForm.getLocationsId());
            CoreCompetency coreCompetency = (CoreCompetency) jobForm.getJobFieldData().findById(jobForm.getCoreCompetenciesId());
            PositionType positionType = (PositionType) jobForm.getJobFieldData().findById(jobForm.getPositionTypesId());
            Job job = new Job(jobForm.getName(), employer, location,
                    positionType, coreCompetency);
            jobData.add(job);
            model.addAttribute("job", job);
            return "job-detail";
        }
        model.addAttribute("title", "Add Job");
        model.addAttribute(jobForm);
        return "new-job";
    }
}
