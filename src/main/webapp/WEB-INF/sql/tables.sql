create table hh_api_Locality (
	id_ LONG not null primary key,
	name VARCHAR(75) null,
	parentId LONG
);

create table hh_api_Region (
	id_ LONG not null primary key,
	name VARCHAR(75) null,
	parentId LONG
);

create table hh_api_Vacancy (
	id_ LONG not null primary key,
	name VARCHAR(300) null,
	publishedAt VARCHAR(300) null,
	employer VARCHAR(300) null,
	salary VARCHAR(300) null,
	address VARCHAR(300) null
);