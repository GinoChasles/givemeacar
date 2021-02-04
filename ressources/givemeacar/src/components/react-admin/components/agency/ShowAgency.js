import * as React from "react";

import { useTranslate } from "react-admin";

import {
    Show,
    SimpleShowLayout,
    TextField,

} from "react-admin";


const ShowAdgency = (props) => {

    const t = useTranslate();

    return <Show {...props} title={t('word.description')}>
        <SimpleShowLayout>
            <TextField source="id" label={t("word.id")} />
            <TextField source="name" label={t("word.name")} />
            <TextField source="address" label={t("word.address")} />
        </SimpleShowLayout>
    </Show>
}

export default ShowAdgency;
