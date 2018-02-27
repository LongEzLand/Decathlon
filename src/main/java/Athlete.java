import java.util.ArrayList;
import java.util.List;

public class Athlete {

    private String athleteName;
    private int score=0;
    private String place;
    private List<EventResult> eventResults = new ArrayList<>();

    public Athlete(String athleteName, int score, String place) {
        this.athleteName = athleteName;
        this.score = score;
        this.place = place;
    }

    public Athlete() {

    }

    public String getAthleteName() {
        return athleteName;
    }

    public void setAthleteName(String athleteName) {
        this.athleteName = athleteName;

    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public List<EventResult> getEventResults() {
        return eventResults;
    }

    public void setEventResults(List<EventResult> eventResults) {
        this.eventResults = eventResults;
    }




    //output should be like this:
/*
<?xml version="1.0" encoding="UTF-8"?>
<decathlonResults>
  <athlete>
     <name>John Smith</name>
     <results>
         <place>1</place>
         <score>7000</score>
         <disciplines>
             <hundredDash type="track">12.61</hundredDash>
             <longJump type="field">5.00</longJump>
             <shotPut type="field">9.22</shotPut>
             <highJump type="field">1.50</highJump>
             <fourHundredDash type="track">60.39</fourHundredDash>
             <hundredTenHurdles type="track">16.43</hundredTenHurdles>
             <discusThrow type="field">21.60</discusThrow>
             <poleVault type="field">2.60</poleVault>
             <javelinThrow type="field">35.81</javelinThrow>
             <thousandFiveHundred type="track">5.25.72</thousandFiveHundred>
         </disciplines>
     </results>
  </athlete>
</decathlonResults>


*/
}

