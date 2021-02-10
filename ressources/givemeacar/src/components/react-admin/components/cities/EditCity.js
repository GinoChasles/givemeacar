import { Edit, SimpleForm, useTranslate } from "react-admin";
import * as React from "react";

import Name from '../form/name'
import Latitude from '../form/latitude'
import Longitude from '../form/longitude'
import Department from '../form/department'
import Zipcode from '../form/zipcode'

import styles from '../../styles/forms.module.css';

const EditCity = (props) => {

    const t = useTranslate();

    return <Edit {...props} undoable={false} title={t('word.edition')}>
        <SimpleForm>
            <section className={styles.form}>

            <Zipcode />

            <Name />

            <Latitude />

            <Longitude />

            <Department />
            </section>

        </SimpleForm>
    </Edit>
}

export default EditCity