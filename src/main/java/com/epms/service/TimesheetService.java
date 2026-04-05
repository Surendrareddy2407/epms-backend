package com.epms.service;

import com.epms.entity.Timesheet;
import com.epms.repository.TimesheetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimesheetService {

    private final TimesheetRepository timesheetRepository;

    public TimesheetService(TimesheetRepository timesheetRepository) {
        this.timesheetRepository = timesheetRepository;
    }

    public Timesheet createTimesheet(Timesheet timesheet) {
        return timesheetRepository.save(timesheet);
    }

    public List<Timesheet> getAllTimesheets() {
        return timesheetRepository.findAll();
    }
}