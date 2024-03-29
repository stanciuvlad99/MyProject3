package ro.mycode.models;

public class Job {
    private int jobId=0;
    private String name="";
    private String department="";

    public Job(int jobId, String name, String department) {
        this.jobId = jobId;
        this.name = name;
        this.department = department;
    }

    public Job(String text){
        String []split=text.split(",");
        this.jobId=Integer.parseInt(split[0]);
        this.name=split[1];
        this.department=split[2];
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String descriere(){
        String descreire="Id-ul jobului este " + jobId + ", numele este " + name + ", iar departamentul este "
                + department;
        return descreire;
    }

    public String toSave(){
        return this.jobId + "," + this.name + "," +this.department;
    }
}
