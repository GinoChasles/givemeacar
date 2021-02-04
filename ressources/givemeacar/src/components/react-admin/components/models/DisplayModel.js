import {
    Datagrid, Filter, List, ReferenceInput, SearchInput, TextField, useTranslate
} from "react-admin";
import * as React from "react";

const PostFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
        <ReferenceInput source="brand_id" reference="brands" allowEmpty>
            <SearchInput optionText="name" />
        </ReferenceInput>
    </Filter>
);

const DisplayModel = (props) => {

    const t = useTranslate();

    return <List {...props} title="Modèles" filter={PostFilter}>
        <Datagrid rowClick="edit">

            <TextField label={t('custom.name')} source="name" />

            <TextField label={t('custom.brand')} source="brandName" />

        </Datagrid>
    </List>
}

export default DisplayModel