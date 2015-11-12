package ua.com.juja.tervola.sqlcmd.service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by user on 11/12/2015.
 */
public class ServiceImpl implements Service {
    @Override
    public List<String> commandsList() {
        return Arrays.asList("help","menu","connect");
    }
}
