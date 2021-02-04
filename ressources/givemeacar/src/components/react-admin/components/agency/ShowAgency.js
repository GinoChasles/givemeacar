import * as React from "react";

import { useTranslate } from "react-admin";

import {
    Show,
    SimpleShowLayout,
    TextField,

} from "react-admin";


const ShowAdgency = (props) => {

    const t = useTranslate();

    return <Show {...props} title={t('custom.description')}>
        <SimpleShowLayout>
            <TextField source="id" label={t("custom.id")} />
            <TextField source="name" label={t("custom.name")} />
            <TextField source="address" label={t("custom.address")} />
        </SimpleShowLayout>
    </Show>
}

export default ShowAdgency;
