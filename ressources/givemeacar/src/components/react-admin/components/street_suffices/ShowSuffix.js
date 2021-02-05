import * as React from "react";

import { useTranslate } from "react-admin";

import {
    Show,
    SimpleShowLayout,
    TextField,

} from "react-admin";

import styles from '../../styles/shows.module.css';

const ShowSuffix = (props) => {

    const t = useTranslate();

    return <Show {...props} title={t('word.description')}>
        <SimpleShowLayout className={styles.show}>
            <TextField label={t('word.id')} source="id" />

            <TextField label={t('word.name')} source="name" />
        </SimpleShowLayout>
    </Show>
}

export default ShowSuffix;
