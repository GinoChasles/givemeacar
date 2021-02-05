import * as React from "react";

import { useTranslate } from "react-admin";

import {
    Show,
    SimpleShowLayout,
    TextField,

} from "react-admin";

import styles from '../../styles/shows.module.css';

const ShowAgency = (props) => {

    const t = useTranslate();

    return <Show {...props} title={t('word.description')}>
        <SimpleShowLayout className={styles.show}>

            <TextField source="id" label={t("word.id")} />

            <TextField source="name" label={t("word.name")} />

            <TextField source="streetNumber" label={t("word.number")} />

            <TextField source="streetSuffixName" label={t("word.suffix")} />

            <TextField source="streetName" label={t("word.street")} />

            <TextField source="zipCode" label={t("word.zipcode")} />

            <TextField source="cityName" label={t("word.city")} />

        </SimpleShowLayout>
    </Show>
}

export default ShowAgency;
