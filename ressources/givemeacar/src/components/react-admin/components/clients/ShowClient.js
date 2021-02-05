import * as React from "react";

import { useTranslate } from "react-admin";

import {
    Show,
    SimpleShowLayout,
    TextField,
    EmailField,
    ReferenceField

} from "react-admin";

import styles from '../../styles/shows.module.css';


const ShowClient = (props) => {

    const t = useTranslate();

    return <Show {...props} title={t('word.description')}>
        <SimpleShowLayout className={styles.show}>

            <TextField label={t('word.id')} source="id" />

            <TextField label={t('word.firstName')} source="firstName" />

            <TextField label={t('word.lastName')} source="lastName" />

            <EmailField label={t('word.mail')} source="mail" />

            <TextField label={t('word.phone')} source="phone" />

            <TextField source="streetNumber" label={t("word.number")} />

            <TextField source="streetSuffixName" label={t("word.suffix")} />

            <TextField source="streetName" label={t("word.street")} />

            <TextField source="zipCode" label={t("word.zipcode")} />

            <TextField source="cityName" label={t("word.city")} />
            
            <ReferenceField link='show' label={t('word.agency')} source="agency_id" reference="agencies">
                <TextField source="name" />
            </ReferenceField>
        </SimpleShowLayout>
    </Show>
}

export default ShowClient;
