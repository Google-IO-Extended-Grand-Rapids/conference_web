# Database Objects

## User
- id
- login_id 
- first_name
- last_name
- email_address
- create_dttm
- last_update_dttm

## User Credentials
- id
- user_id (FK)
- password
- active_ind
- create_dttm
- last_update_dttm

# Conference
- id
- name
- short_desc
- full_desc
- start_date
- end_date
- location_id (FK)
- create_dttm
- last_update_dttm

# Location
- id
- name
- short_desc
- full_desc
- create_dttm
- last_update_dttm
- parking_information

# Location Address
- id
- location_id (FK)
- address1
- address2
- city
- state
- zip
- latitude
- longitude
- create_dttm
- last_update_dttm

# Conference_Session 
- id
- name
- short_desc
- full_desc
- conference_id (FK)
- conference_session_type_id (FK)
- conference_session_presenter (FK)
- room_id (FK)
- start_dttm
- end_dttm
- create_dttm
- last_update_dttm

# Conference Session Presenter
- id
- conference_session_id (FK)
- presenter_id (FK)

# Presenter 
- id
- user_id
- short_bio
- company_affiliation_id (FK)
- job_title

# Conference Session Registration
- id
- user_id (FK)
- conference_session_id (FK)

# Conference Session Type
- id
- name
- desc

# Sponsor
- id
- name
- logo_path
- home_page_url
- sponsor_level (FK)

# Sponsor Level
- id
- conference_id (FK)
- description

# Company
- id
- name
- short description
- long description
- logo path

# Room
- id
- short desc
- long desc
- conference_id (FK)
