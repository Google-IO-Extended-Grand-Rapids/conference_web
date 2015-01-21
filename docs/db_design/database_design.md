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

# Location Address
- id
- location_id (FK)
- address1
- address2
- city
- state
- zip
- create_dttm
- last_update_dttm

# Event
- id
- name
- short_desc
- full_desc
- conference_id (FK)
- event_type_id (FK)
- facilitator_id (FK)
- start_dttm
- end_dttm
- create_dttm
- last_update_dttm

# Event Registration
- id
- user_id (FK)
- event_id (FK)

# Event Type
- id
- name
- desc

# Facilitator
- id
- user_id
- short_bio
