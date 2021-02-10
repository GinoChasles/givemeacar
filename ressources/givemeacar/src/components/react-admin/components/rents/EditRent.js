import {
    DateTimeInput, Edit, SimpleForm, useTranslate, required
} from "react-admin";
import * as React from "react";

import Client from '../form/client';
import Car from '../form/car';

import styles from '../../styles/forms.module.css';

const EditRent = (props) => {

    const t = useTranslate();

    return <Edit {...props} undoable={false} title={t('word.edition')}>
        <SimpleForm>
            <section className={styles.form}>

            <DateTimeInput label={t('word.rentStart')} source="start" validate={[
                required()
            ]} />

            <DateTimeInput label={t('word.rentEnd')} source="end" validate={[
                required()
            ]} />

            <Car />

            <Client />
            </section>

        </SimpleForm>
    </Edit>
}

export default EditRent