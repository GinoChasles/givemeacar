import {
    Datagrid, Filter, List, ReferenceInput, SearchInput, TextField, ReferenceField, useTranslate
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

    return <List {...props} title={t('custom.models')} filter={PostFilter}>
        <Datagrid rowClick="edit">
            <TextField label={t('custom.id')} source="id" />

            <TextField label={t('custom.name')} source="name" />

            <ReferenceField label={t('custom.brand')} source="brand_id" reference="brands">
                <TextField source="name" />
            </ReferenceField>
        </Datagrid>
    </List>
}

export default DisplayModel