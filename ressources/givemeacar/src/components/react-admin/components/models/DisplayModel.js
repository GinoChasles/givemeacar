import {
    Datagrid, Filter, List, SearchInput, TextField, ReferenceField, useTranslate, EditButton, DeleteButton
} from "react-admin";
import * as React from "react";

const ModelFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
    </Filter>
);

const DisplayModel = (props) => {

    const t = useTranslate();

    return <List {...props} title={t('word.models')} filter={ModelFilter} exporter={false} perPage={25}>
        <Datagrid hasBulkActions rowClick="show">


            <TextField label={t('word.name')} source="name" />

            <ReferenceField label={t('word.brand')} source="brand_id" reference="brands">
                <TextField source="name" />
            </ReferenceField>

            <EditButton />

            <DeleteButton />
        </Datagrid>
    </List>
}

export default DisplayModel