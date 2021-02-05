import { Edit, SimpleForm, useTranslate } from "react-admin";
import * as React from "react";

import City from '../form/city';
import Street from '../form/street';
import Suffix from '../form/suffix';
import Name from '../form/name';
import StreetNumber from '../form/streetNumber';

import styles from '../../styles/forms.module.css';

const EditAgency = (props) => {

    const t = useTranslate();

    return <Edit {...props} undoable={false} title={t('word.edition')}>
        <SimpleForm>
            <section className={styles.form}>

            <Name />
            <StreetNumber />
            <Suffix />
            <Street />
            <City />
            </section>

        </SimpleForm>
    </Edit>
}

export default EditAgency