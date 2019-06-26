package structural.flyweight;

/**
 * @author HT
 * @version V1.0
 * @package structural.flyweight
 * @date 2019-06-25 00:29
 */
public class Manager implements Employee {
    private String title = "部门经理";

    private String department;

    private String reportContent;

    public Manager(String department) {
        this.department = department;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    @Override
    public void report() {
        System.out.println(reportContent);
    }
}
