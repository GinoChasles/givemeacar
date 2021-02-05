import * as React from "react";

import { Edit, SimpleForm, useTranslate } from "react-admin";

import Name from '../form/name';

import styles from '../../styles/forms.module.css';

const EditBrand = (props) => {

    const t = useTranslate();

    return <Edit {...props} undoable={false} title={t('word.edition')}>
        <SimpleForm>
            <section className={styles.form}>

            <Name />
            </section>

        </SimpleForm>
    </Edit>
}

export default EditBrand