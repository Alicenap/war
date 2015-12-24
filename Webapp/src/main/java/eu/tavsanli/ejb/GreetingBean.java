package eu.tavsanli.ejb;

import javax.ejb.Stateless;

@Stateless
public class GreetingBean {
    public String getGreeting(){
        return "Hello Docker";
    }
}
