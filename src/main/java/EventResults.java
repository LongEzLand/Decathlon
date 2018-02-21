public class EventResults {

    private double hundredDash;
    private double longJump;
    private double shotPut;
    private double highJump;
    private double fourHundredDash;
    private double hundredTenHurdles;
    private double discusThrow;
    private double poleVault;
    private double javelinThrow;
    private String thousandFiveHundred;

    public EventResults(double hundredDash, double longJump, double shotPut, double highJump,
                        double fourHundredDash, double hundredTenHurdles, double discusThrow,
                        double poleVault, double javelinThrow, String thousandFiveHundred) {//constructor
        this.hundredDash = hundredDash;
        this.longJump = longJump;
        this.shotPut = shotPut;
        this.highJump = highJump;
        this.fourHundredDash = fourHundredDash;
        this.hundredTenHurdles = hundredTenHurdles;
        this.discusThrow = discusThrow;
        this.poleVault = poleVault;
        this.javelinThrow = javelinThrow;
        this.thousandFiveHundred = thousandFiveHundred;
    }

    public EventResults(){

    }
    public double getHundredDash() {
        return hundredDash;
    }

    public void setHundredDash(double hundredDash) {
        this.hundredDash = hundredDash;
    }

    public double getLongJump() {
        return longJump;
    }

    public void setLongJump(double longJump) {
        this.longJump = longJump;
    }

    public double getShotPut() {
        return shotPut;
    }

    public void setShotPut(double shotPut) {
        this.shotPut = shotPut;
    }

    public double getHighJump() {
        return highJump;
    }

    public void setHighJump(double highJump) {
        this.highJump = highJump;
    }

    public double getFourHundredDash() {
        return fourHundredDash;
    }

    public void setFourHundredDash(double fourHundredDash) {
        this.fourHundredDash = fourHundredDash;
    }

    public double getHundredTenHurdles() {
        return hundredTenHurdles;
    }

    public void setHundredTenHurdles(double hundredTenHurdles) {
        this.hundredTenHurdles = hundredTenHurdles;
    }

    public double getDiscusThrow() {
        return discusThrow;
    }

    public void setDiscusThrow(double discusThrow) {
        this.discusThrow = discusThrow;
    }

    public double getPoleVault() {
        return poleVault;
    }

    public void setPoleVault(double poleVault) {
        this.poleVault = poleVault;
    }

    public double getJavelinThrow() {
        return javelinThrow;
    }

    public void setJavelinThrow(double javelinThrow) {
        this.javelinThrow = javelinThrow;
    }

    public String getThousandFiveHundred() {
        return thousandFiveHundred;
    }

    public void setThousandFiveHundred(String thousandFiveHundred) {
        this.thousandFiveHundred = thousandFiveHundred;
    }
}
