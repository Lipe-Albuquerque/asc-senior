
    alter table agendamento 
       add constraint fk_agendamento_medical_id 
       foreign key (medical_id) 
       references user_;

    
    alter table agendamento 
       add constraint fk_agendamento_patient_id 
       foreign key (patient_id) 
       references user_;
