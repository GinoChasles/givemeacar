import * as React from "react";
import {
    Create,
    SimpleForm,
    useTranslate
} from "react-admin";


import FirstName from '../form/firstName';
import LastName from '../form/lastName';
import Mail from '../form/mail';
import Phone from '../form/phone';
import Password from '../form/password';
import styles from '../../styles/forms.module.css';

const CreateManager = (props) => {

    const t = useTranslate();

    return <Create {...props} title={t('word.creation')}>
        <SimpleForm>
            <section className={styles.form}>

            <FirstName />
            <LastName />
            <Mail />
            <Phone />
            <Password />
            </section>

        </SimpleForm>
    </Create>
}
export default CreateManager
