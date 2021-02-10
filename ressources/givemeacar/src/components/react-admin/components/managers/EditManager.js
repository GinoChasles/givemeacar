import {
    Edit, SimpleForm, useTranslate
} from "react-admin";
import * as React from "react";

import FirstName from '../form/firstName';
import LastName from '../form/lastName';
import Mail from '../form/mail';
import Phone from '../form/phone';
import Password from '../form/password';

import styles from '../../styles/forms.module.css';

const EditManager = (props) => {

    const t = useTranslate();

    return <Edit {...props} undoable={false} title={t('word.edition')}>
        <SimpleForm>
            <section className={styles.form}>

                 
            <FirstName />
            <LastName />
            <Mail />
            <Phone />
            <Password />
            </section>

        </SimpleForm>
    </Edit>
}

export default EditManager