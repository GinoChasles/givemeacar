import { Edit, SimpleForm, TextInput, useTranslate } from "react-admin";
import * as React from "react";

import Name from '../form/name';

import styles from '../../styles/forms.module.css';

const EditColor = (props) => {

    const t = useTranslate();

    return <Edit {...props} undoable={false} title={t('word.edition')}>
        <SimpleForm>
            <section className={styles.form}>

            <Name />
            </section>

        </SimpleForm>
    </Edit>
}

export default EditColor