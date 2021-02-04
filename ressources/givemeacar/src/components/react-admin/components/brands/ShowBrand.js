import * as React from "react";

import { useTranslate } from "react-admin";

import {
    Show,
    SimpleShowLayout,
    TextField,

} from "react-admin";


const ShowBrand = (props) => {

    const t = useTranslate();

    return <Show {...props} title={t('custom.description')}>
        <SimpleShowLayout>
            <TextField source="name" label={t("custom.name")} />
        </SimpleShowLayout>
    </Show>
}

export default ShowBrand;
