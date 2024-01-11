package com.expressdevs.project.run;

import com.expressdevs.project.model.DTO.MemberDTO;
import com.expressdevs.project.train.TrainDTO;
import com.expressdevs.project.view.TicketingMenu;
import java.util.ArrayList;
import java.util.List;

public class Application {


    public static List<MemberDTO> memberList = new ArrayList<>();
    public static List<TrainDTO> timeSchedule = new ArrayList<>();

    public static void main(String[] args) {

        new TicketingMenu().mainMenu();
    }

}
