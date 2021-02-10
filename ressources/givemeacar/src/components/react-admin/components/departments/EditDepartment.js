import {
    Edit, SimpleForm, useTranslate
} from "react-admin";
import * as React from "react";

import Name from '../form/name';
import Code from '../form/code';
import Region from '../form/region';

import styles from '../../styles/forms.module.css';

const EditDepartments = (props) => {

    const t = useTranslate();

    return <Edit {...props} undoable={false} title={t('word.edition')}>
        <SimpleForm>
            <section className={styles.form}>

            <Region />

            <Code />

            <Name />
            </section>

        </SimpleForm>
    </Edit>
}

export default EditDepartments