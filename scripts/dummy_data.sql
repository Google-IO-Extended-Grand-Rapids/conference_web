INSERT INTO conf_admin.location(
             name, short_desc, full_desc, parking_info, create_dttm, last_update_dttm)
    VALUES ('Sample Location', 'short', 'full', 'no parking', CURRENT_DATE, CURRENT_DATE);

INSERT INTO conf_admin.conference(
            name, short_desc, full_desc, start_date, end_date, location_id,
            create_dttm, last_update_dttm)
    select 'Sample Conference', 'short desc', 'full desc', CURRENT_DATE - 1, CURRENT_DATE, location.id,
            CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
            from conf_admin.location where location.name = 'Sample Location';

INSERT INTO conf_admin.room(
            short_desc, full_desc, conference_id)
    select 'Short Description', 'Full Description', conference.id
               from conf_admin.conference where conference.name = 'Sample Conference';

insert into conf_admin.company
(name, short_desc, full_desc, logo_path) values ('GFS', 'Gordon Food Service', 'Food distribution', 'http://logo_path/gfs.png');

INSERT INTO conf_admin.presenter(
            user_id, short_bio, job_title, company_affiliation_id)
    VALUES (null, 'short bio', 'sample title', 1);

INSERT INTO conf_admin.conference_session(
            name, short_desc, full_desc, conference_id, conference_session_type_id,
            room_id, start_dttm, duration, create_dttm, last_update_dttm,
            conference_session_presenter_id)
    SELECT 'Session name', 'short desc', 'full desc', conference.id, null,
            room.id, CURRENT_DATE, 30, CURRENT_DATE, CURRENT_DATE,
            null
           from conf_admin.conference,conf_admin.room where conference.name = 'Sample Conference' and room.short_desc = 'Short Description';

INSERT INTO conf_admin.conference_session_presenter(
             conference_session_id, presenter_id)
    select conference_session.id, presenter.id
    from conf_admin.presenter, conf_admin.conference_session
    where presenter.job_title = 'sample title' and conference_session.name = 'Session name';




select * from conf_admin.company;


/*
select * from conf_admin.conference;
select * from conf_admin.location;
select * from conf_admin.presenter;
select * from conf_admin.room;
select * from conf_admin.conference_session;
select * from conf_admin.conference_session_presenter;
select * from conf_admin.conference;

SELECT *
  FROM conf_admin.location;

SELECT *
  FROM conf_admin.company;

SELECT *
  FROM conf_admin.conference_session_type;

SELECT *
  FROM conf_admin.location_address;

SELECT *
  FROM conf_admin.room;

SELECT *
  FROM conf_admin.sponsor_level;
*/
/* Trying to delete stuff in the right order */
/*
delete from conf_admin.conference_session_presenter cascade;
delete from conf_admin.conference_session cascade;
delete from conf_admin.room cascade;
delete from conf_admin.conference cascade;
delete from conf_admin.location_address cascade;
delete from conf_admin.location cascade;
delete from conf_admin.presenter cascade;
delete from conf_admin.conference cascade;
*/