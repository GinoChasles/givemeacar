import * as React from "react";

import { useTranslate } from "react-admin";

import {
    Show,
    SimpleShowLayout,
    TextField,
    ReferenceField

} from "react-admin";

import styles from '../../styles/shows.module.css';


const ShowCity = (props) => {

    const t = useTranslate();

    return <Show {...props} title={t('word.description')}>
        <SimpleShowLayout className={styles.show}>
            <TextField label={t('word.id')} source="id" />
            <TextField label={t('word.name')} source="name" />
            <TextField label={t('word.zipcode')} source="zipcode" />
            <ReferenceField link="show" label={t('word.department')} source="department_id" reference="departments">
                <TextField source="name" />
            </ReferenceField>
            <ReferenceField link="show" label={t('word.region')} source="regionId" reference="regions">
                <TextField source="name" />
            </ReferenceField>
        </SimpleShowLayout>
    </Show>
}

export default ShowCity;
