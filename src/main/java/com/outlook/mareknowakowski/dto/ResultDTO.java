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

public class ResultDTO
{
	private String name;
	private Integer birthYear;
	private String club;
	private CompetitionDTO competition;
	private Integer place;


	private ResultDTO(){}

	public String getName()
	{
		return name;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public Integer getBirthYear()
	{
		return birthYear;
	}

	public void setBirthYear(final Integer birthYear)
	{
		this.birthYear = birthYear;
	}

	public String getClub()
	{
		return club;
	}

	public void setClub(final String club)
	{
		this.club = club;
	}

	public CompetitionDTO getCompetition()
	{
		return competition;
	}

	public void setCompetition(final CompetitionDTO competition)
	{
		this.competition = competition;
	}

	public Integer getPlace()
	{
		return place;
	}

	public void setPlace(final Integer place)
	{
		this.place = place;
	}
}
