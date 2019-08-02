package com.example.myservice.service.messaging;

import com.example.myservice.service.ClpSerializer;
import com.example.myservice.service.LocalityLocalServiceUtil;
import com.example.myservice.service.RegionLocalServiceUtil;
import com.example.myservice.service.VacancyLocalServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            LocalityLocalServiceUtil.clearService();

            RegionLocalServiceUtil.clearService();

            VacancyLocalServiceUtil.clearService();
        }
    }
}
