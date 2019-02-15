package com.rajnish.vo;

import java.text.ParseException;
import java.util.Date;

import com.rajnish.util.Constants;

public class ToolUsage
{
    private String useEndTime;

    private String useStartTime;

    private String name;
    
    private long usageInMins;

    public long getUsageInMins() {
    	
    	try {
    		
			Date d1 = Constants.sdf.parse(useStartTime);
			Date d2 = Constants.sdf.parse(useEndTime);
			long diff = d2.getTime() - d1.getTime();
			
			usageInMins = diff / (60 * 1000);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	
		return usageInMins;
	}

	public void setUsageInMins(long usageInMins) {
		this.usageInMins = usageInMins;
	}

	public String getUseEndTime ()
    {
        return useEndTime;
    }

    public void setUseEndTime (String useEndTime)
    {
        this.useEndTime = useEndTime;
    }

    public String getUseStartTime ()
    {
        return useStartTime;
    }

    public void setUseStartTime (String useStartTime)
    {
        this.useStartTime = useStartTime;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [useEndTime = "+useEndTime+", useStartTime = "+useStartTime+", name = "+name+"]";
    }
}
