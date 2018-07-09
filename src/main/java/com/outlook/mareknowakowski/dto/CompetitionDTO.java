/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2018 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 */
package com.outlook.mareknowakowski.dto;

public class CompetitionDTO
{
    private String name;
    private String date;

    private CompetitionDTO(){
        
    }

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(final String date)
    {
        this.date = date;
    }
}
