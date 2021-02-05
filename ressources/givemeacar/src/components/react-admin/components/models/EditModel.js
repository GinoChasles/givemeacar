import {
    Edit, SimpleForm, useTranslate
} from "react-admin";
import * as React from "react";

import Name from '../form/name';
import Brand from '../form/brand';

import styles from '../../styles/forms.module.css';

const EditModel = (props) => {

    const t = useTranslate();

    return <Edit {...props} undoable={false} title={t('word.edition')}>
        <SimpleForm>
            <section className={styles.form}>

            <Brand />

            <Name />
            </section>

        </SimpleForm>
    </Edit>
}
export default EditModel