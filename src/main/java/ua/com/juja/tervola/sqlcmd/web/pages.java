package ua.com.juja.tervola.sqlcmd.web;

/**
 * Created by user on 12/1/2015.
 */
public enum Pages {
    ERROR("view/error.jsp"),
    MENU("view/menu.jsp"),
    HELP("view/help.jsp"),
    CONNECT("view/connect.jsp"),
    CLEAN_LOGS("view/log_clean.jsp"),
    MOCK("view/connect_mock.jsp"),
    SELECT("view/select.jsp"),
    SELECT_MOCK("view/select_mock.jsp"),
    EXECUTE("view/execute.jsp"),
    EXECUTE_MOCK("view/execute_mock.jsp"),
    EXECUTE_RESULT("view/execute_result.jsp"),
    SELECT_RESULTS("view/select_result.jsp"),
    LIST("view/list.jsp");

    private final String page;

    Pages(final String page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return page;
    }

}
